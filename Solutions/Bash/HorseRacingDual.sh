# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.

read N
for (( i=0; i<N; i++ )); do
    read Pi[i]
done

readarray -t sorted < <(printf '%s\n' "${Pi[@]}" | sort -g)


a=${sorted[1]}
b=${sorted[0]}
gap=$(( $a-$b ))
for ((i=1; i < ${#sorted[@]}; i++))
do
    a=${sorted[i]}
    tgap=$(($a-$b))
    if [ "$tgap" -lt "$gap" ]
        then gap=$tgap
        fi 
    b=${sorted[i]}
done

echo "$gap"