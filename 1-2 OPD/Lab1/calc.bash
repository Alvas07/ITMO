#!/bin/bash
if [[ -n "$1" ]]; then
	num_of_operations=$1
	counter=0
	result=0
	echo "Enter the first number:"
	read num1
	if [[ -n "$num1" && $num1 =~ ^-?[0-9]+$ ]]; then
		while [[ $counter -lt $num_of_operations ]]; do
			echo "Choose command (+, -, *, /) or write "STOP" to terminate the program:"
			read command
			if [[ "$command" == "STOP" ]]; then
				if [[ "$result" == "0" ]]; then
					result=$num1
				fi
				echo "The final result is $result"
				echo "The program is finished."
				exit
			elif [[ "$command" != + && "$command" != - && "$command" != \* && "$command" != / ]]; then
				echo "The program is finished."
				exit
			fi
			echo "Enter the second number:"
			read num2
			if [[ -n "$num2" && $num2 =~ ^-?[0-9]+$ ]]; then
				case $command in
					"+") let "result = num1 + num2";;
					"-") let "result = num1 - num2";;					
					"*") let "result = num1 * num2";;
					"/") if [[ $num2 != 0 ]]; then
							let "result = num1 / num2"
						else
							echo "Division by zero."
							echo "The program is finished."
							exit
						fi
				esac
				echo "Intermediate result is $result"
				num1=$result
			else
				echo "Second variable is not a number." >&2
				echo "The program is finished."
				exit
			fi
		let "counter = counter + 1"
		done
	else
		echo "First variable is not a number." >&2
		echo "The program is finished."
		exit
	fi
else
	echo "No required parametres found" >&2
	echo "The program is finished."
	exit
fi
echo "The final result is $result"
echo "The program is finished."
