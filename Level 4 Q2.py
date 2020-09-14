#escape-pods
def bfs(matrix, source, dest):
    visited = [-1 for i in range(len(matrix))]
    visited[source] = source
    queue = [source]
    while len(queue) > 0:
        top = queue.pop(0)
        for i in range(len(matrix)):
            if(matrix[top][i][1] - matrix[top][i][0]) != 0 and visited[i] ==-1:
                if i == dest:
                    visited[dest]=top
                    path = [dest]
                    temp=dest
                    while temp != source:
                        temp = visited[temp]
                        path.append(temp)
                    path.reverse()
                    temp =1
                    total = float("inf")
                    current = source
                    while temp != len(path):
                        entry = matrix[current][path[temp]]
                        diff = abs(entry[1]) - entry[0]
                        total = min(total,diff)
                        current = path[temp]
                        temp += 1
                    temp =1
                    current = source
                    while temp!=len(path):
                        entry = matrix[current][path[temp]]
                        if entry[1] < 0:
                            entry[1]+=total
                        else:
                            entry[0]+=total
                        entry = matrix[path[temp]][current]
                        if entry[1]<=0:
                            entry[1] -=total
                        else:
                            entry[0]+=total
                        current = path[temp]
                        temp+=1
                    return True
                else:
                    visited[i] = top
                    queue.append(i)
    return False
    
def solution(entrances, exits, path):
    max_val = sum(list(map(sum, path)))
    a = []
    for i in range(len(path)):
        a.append([])
        for j in range(len(path[i])):
            a[i].append([0, path[i][j]])
        a[i].append([0, 0])
        if i in exits:
            a[i].append([0, max_val])
        else:
            a[i].append([0, 0])
    a.append([])
    a.append([])
    for i in range(len(path[0]) +2):
        if i in entrances:
            a[-2].append([0, max_val])
        else:
            a[-2].append([0, 0])
        a[-1].append([0, 0])
    while(bfs(a, len(a)-2, len(a)-1)):
        pass
    total =0
    for i in range(len(a)):
        total+=a[-2][i][0]
    return total
