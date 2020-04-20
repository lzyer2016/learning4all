func findNumbers(nums []int) int {
    ret :=0
	for i:=0; i<len(nums); i++{
		count := countBit(nums[i])
		if count & 1 == 0{
			ret++
		}
	}
	return ret
}

func countBit(num int) int{
	countBit :=0
	for num!=0 {
		countBit++
		num /= 10
	}
	return countBit
}