def soln(path : str) -> int:
    count = 0
    d = 50
    prev = d
    with open(path, 'r') as f:
        for line in f:
            
            line = line.strip()
            print(line) 
            prev = d
            print("prev:", prev)

            if line[0] == "L":
                d -= int(line[1:])
            else:
                d += int(line[1:])
            
            if d > 0:
                count+=int(d/100)
            else:
                count+=abs(int(d/100)) + 1
                if prev == 0:
                    count -= 1
                
            d%=100
            print("d:",d)
            print("count:",count)
                
            

    return count

print(soln("./input.txt"))
# print(soln("./sample_input.txt"))