func replaceElements(arr []int) []int {
	if arr == nil {
		return nil
	}
	ret := make([]int, len(arr))
	max:=-1
	ret[len(arr)-1]=max
	for i:=len(arr)-2; i>=0; i--{
		if arr[i+1] > max{
			max = arr[i+1]
		}
		ret[i] = max
	}
	return ret
}