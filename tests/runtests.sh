#!/bin/bash

# =========== CONSTANTS ===========
# Return values
readonly RET_success=0
readonly RET_error=1
readonly RET_usage=2
readonly RET_help=2

# Colors
readonly RCol='\033[0m'                 # Text Reset
readonly Whi='\033[0;37m'               # White, for small details
readonly Red='\033[0;31m'               # Red, for small details
readonly Gre='\033[0;32m'               # Green, for small details
readonly Yel='\033[0;33m'               # Yellow, for mid-building
readonly BRed='\033[1;31m'              # Bold Red, when an error occurred
readonly BGre='\033[1;32m'              # Bold Green, for successes
readonly BYel='\033[1;33m'              # Bold Yellow, when building stuff
readonly BWhi='\033[1;37m'              # Bold White, when beginning something
readonly URed='\033[4;31m'              # Underline Red, for warnings
readonly UGre='\033[4;32m'              # Underline Green, for smaller successes
readonly UBlu='\033[4;34m'              # Underline Blue, for links
readonly UWhi='\033[4;37m'              # Underline White, for commands

# Strings
readonly Note="${UWhi}Notice${Whi}:${RCol}"
readonly Warn="${BYel}Warning${Yel}:${RCol}"
readonly Err="${BRed}Error${Red}:${RCol}"

readonly ScriptName="$0"

# String Arrays
readonly usage_content=( "Usage: $(basename $ScriptName)"
"HELP:
	-h : Shows this message"
"DIRECTORIES:
	-a : Set Java app directory
	-s : Set \"support\" directory (containing any necessary packages)
	-t : Set tests directory"
"OPTIONS:
	--show-all : Prints successes as well"
)

# Files & Directories
readonly DIR_current="$(pwd)"
readonly EXEC_javaApp="pex.app.App"

# Options
BOOL_recursive=true
BOOL_showAll=false

# =========== FUNCTIONS ===========
function usage {
	for i in `seq 0 ${#usage_content[@]}`; do
		echo -e "${usage_content[i]}"
	done
    exit $RET_usage
}

function get_absolute_dir {
	# $1 : directory to parse
	cd "$1" > /dev/null
	temp_dir="$(pwd)"
	cd - > /dev/null
	echo "$temp_dir"
}

function parse_args {
	if [ $# -eq 0 ]; then return 0; fi

	while [ $# -gt 0 ]; do
		case $1 in
			# DIRECTORIES
			-a )
				shift
				DIR_javaApp="$(get_absolute_dir "$1")"
				;;
			-s )
				shift
				CLASSPATH="$CLASSPATH:$(get_absolute_dir "$1")/*"
				;;
			-t )
				shift
				DIR_tests="$(get_absolute_dir "$1")"
				BOOL_recursive=false
				;;
			# OPTIONS
			--show-all )
				BOOL_showAll=true
				;;
			# HELP
			-h|--help )
				usage
				exit $RET_usage
				;;
			* ) printf "Unknown argument. \"$1\"\n"
				;;
		esac
		shift
	done

	return $RET_success
}

function print_progress {
	# $1 : text to print
	# $2+: formatting args
	printf "\n${BYel}$1\n${RCol}" ${@:2}
}

function print_success {
	# $1 : text to print
	# $2+: formatting args
	printf "\n${UGre}SUCCESS${Gre}:${RCol} $1\n${RCol}" ${@:2}
}

function print_failure {
	# $1 : text to print
	# $2+: formatting args
	printf "\n${URed}FAILURE${Red}:${RCol} $1\n" ${@:2}
}

function print_error {
	# $1 : text to print
	# $2+: formatting args
	printf "\n${BRed}ERROR${Red}:${RCol} $1\n" ${@:2}
}

function check_env {
	if [ ! -d "$DIR_javaApp" ]; then
		print_error "App directory \"$DIR_javaApp\" is not valid"
		return $RET_error
	elif [ $BOOL_recursive == false -a ! -d "$DIR_tests" ]; then
		print_error "Tests directory \"$DIR_tests\" is not valid"
		return $RET_error
	fi
}

function set_env {
	# Defining script directories
	cd "$(dirname "$0")"
	DIR_script="$(pwd)"

	if [ -z "$DIR_javaApp" ]; then
		DIR_javaApp="$DIR_script/../bld"
	fi
	cd "$DIR_javaApp"

	# Copying exclusive files to App's directory if they don't exist
	local FILE_import=( "import" "prim.tex" "prim3.tex" "ex33.pex" "ex34.pex" )
	for impFile in ${FILE_import[@]}; do
		copy_to_app_dir "$DIR_script/$impFile"
	done
}

function copy_to_app_dir {
	myfile="$(basename "$1")"
	if [ -f "$1" -a ! -f "$DIR_javaApp/$myfile" ]; then
		cp "$1" "$DIR_javaApp/$myfile"
	fi
}

# Target functionality
function test_dir {
	# $1 : test directory
	if [ $# -lt 1 ]; then
		print_error "test_dir(): No arguments given."
		return $RET_error
	elif [ ! -d "$1" ]; then
		print_error "Given argument is not a directory."
		return $RET_error
	elif [ -z "$(ls $1/*.in 2> /dev/null)" -o -z "$(ls $1/*.out 2> /dev/null)" ]; then
		print_error "Given directory does not contain any test files."
		return $RET_error
	fi

	# Run tests
	local import_flag=""
	local fail_count=0
	local total_count=0
	for x in $1/*.in; do
		total_count=$(($total_count + 1))
		local test_name="$(basename $1)/$(basename $x)"
		# Setting import flag
	    if [ -e ${x%.in}.import ]; then
			import_flag="-Dimport=${x%.in}.import"
		else
			import_flag=""
	    fi

		java $import_flag -Din=$x -Dout=${x%.in}.outhyp "$EXEC_javaApp"
		if [ $? -ne 0 ]; then
			return $RET_error
		fi

	    diff ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff
		if [[ $x == *"okB"* ]]; then
			continue
	    elif [ -s ${x%.in}.diff ]; then
	        print_failure "$test_name. See file ${test_name%.in}.diff"
			fail_count=$(($fail_count + 1))
	    else
			if [ $BOOL_showAll == true ]; then
				print_success "$test_name"
			fi
	        rm -f ${x%.in}.diff ${x%.in}.outhyp
	    fi
	done

	if [ $fail_count -gt 0 ]; then
		print_failure "Failed $fail_count / $total_count tests."
	fi

	return $fail_count
}

function cleanup {
	rm -rf "$DIR_javaApp"/saved*
}

function main {
	parse_args "$@"
	set_env
	check_env
	if [ $? -eq $RET_error ]; then
		usage
		exit $RET_error
	fi

	local retval=$RET_success
	local fail_count=0
	if [ $BOOL_recursive == true ]; then
		for x in $DIR_script/*/; do
			print_progress "Running through \"$x\""
			test_dir "$x"
			fail_count=$(($fail_count + $?))
		done
	else
		test_dir "$DIR_tests"
		fail_count=$?
	fi
	cleanup

	exit $fail_count
}

# Script starts HERE
main "$@"
