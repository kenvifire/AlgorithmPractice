read N
let sum=0;
let i=1;

while ((i<=N)); do
	read x
	let sum=$sum+x
	let i=$i+1;
done

echo "scale=4;$sum/$N" | bc -l  | xargs printf "%.3f"

