#!/usr/bin/env zsh

c() {
	echo "${funcstack}"

	for ((i=1; i<$#funcstack; i++)); do
		echo "Index: $i, function: ${funcstack[$i]}"
	done
}

b() {
	c
}

a() {
	b
}

a
