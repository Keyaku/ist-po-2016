#!/bin/bash

# =========== CONSTANTS ===========
# Return values
RET_success=0
RET_error=1
RET_usage=2
RET_help=2

# Colors
RCol='\033[0m'					# Text Reset
Red='\033[0;31m'				# Red, for small details
Whi='\033[0;37m'				# White, for small details
Yel='\033[0;33m'				# Yellow, for mid-building
BGre='\033[1;32m'				# Bold Green, for successes
BWhi='\033[1;37m'				# Bold White, when beginning something
BRed='\033[1;31m'				# Bold Red, when an error occurred
BYel='\033[1;33m'				# Bold Yellow, when building stuff
UWhi='\033[4;37m'				# Underline White, for commands
URed='\033[4;31m'				# Underline Red, for warnings
UBlu='\033[4;34m'				# Underline Blue, for links

# Strings
Note="${UWhi}Notice${Whi}:${RCol}"
Warn="${BYel}Warning${Yel}:${RCol}"
Err="${BRed}Error${Red}:${RCol}"

ScriptName="$0"

# Files & Directories
cd "$(dirname "$0")"
DIR_current="$(pwd)"

DIR_tests="$DIR_current/tests"
DIR_javaApp="$DIR_current/../bld"
EXEC_javaApp="pex.app.App"

# String Arrays
usage_content=( "Usage: $(basename $ScriptName)"
"HELP:
	-h : Shows this message"
"DIRECTORIES:
	-a : Add Java app directory
	-t : Add tests directory"
)

# =========== FUNCTIONS ===========
function usage {
	for i in `seq 0 ${#usage_content[@]}`; do
		echo -e "${usage_content[i]}"
	done
    exit $RET_usage
}

function parse_args {
	if [ $# -eq 0 ]; then return 0; fi
	print_progress "Parsing args..."

	while [ $# -gt 0 ]; do
		case $1 in
			-a )
				shift
				DIR_javaApp="$DIR_current/$1"
				;;
			-t )
				shift
				DIR_tests="$DIR_current/$1"
				;;
			-h|--help )
				usage
				exit $RET_usage
				;;
			* ) printf "Unknown argument. \"$1\"\n"
				;;
		esac
		shift
	done

	print_progress "Parsed args."
	return $RET_success
}

function check_env {
	if [ ! -d "$DIR_javaApp" ]; then
		print_error "App directory \"$DIR_javaApp\" is not valid"
		return $RET_error
	elif [ ! -d "$DIR_tests" ]; then
		print_error "Tests directory \"$DIR_tests\" is not valid"
		return $RET_error
	fi

	cd "$DIR_javaApp"
}

function print_progress {
	# $1 : text to print
	printf "\n${BYel}$1\n${RCol}"
}

function print_error {
	# $1 : text to print
	printf "\n${BRed}ERROR${Red}:${RCol} $1\n"
}

# Target functionality
function start_testing {
	for x in $DIR_tests/*.in; do
	    if [ -e ${x%.in}.import ]; then
	        java -Dimport=${x%.in}.import -Din=$x -Dout=${x%.in}.outhyp "$EXEC_javaApp"
	    else
	        java -Din=$x -Dout=${x%.in}.outhyp "$EXEC_javaApp"
	    fi

	    diff ${x%.in}.out ${x%.in}.outhyp > ${x%.in}.diff
	    if [ -s ${x%.in}.diff ]; then
	        echo "FAILURE: $x. See file ${x%.in}.diff "
	    else
	        rm -f ${x%.in}.diff ${x%.in}.outhyp
	    fi
	done
}

function cleanup {
	rm -rf "$DIR_app"/saved*
}

function main {
	parse_args "$@"
	check_env

	if [ $? -eq $RET_error ]; then
		usage
		exit $RET_error
	fi

	cd "$DIR_javaApp"
	start_testing

	print_progress "Done."
}

# Script starts HERE
main "$@"
