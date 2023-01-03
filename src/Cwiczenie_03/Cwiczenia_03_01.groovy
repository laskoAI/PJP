package TaskSet3

def list1 = ['a', 'b', 'c']
def list2 = [1, 8, 23]

println("Listy:")
println("List1:")
list1.each { print("${it} ") }
println("\nList2:")
list2.each { print("${it} ") }

println("\nPodwojone listy:")
println("List1:")
list1 = list1.collect { it * 2 }
list1.each { print("${it} ") }
println("\nList2:")
list2 = list2.collect { it * 2 }
list2.each { print("${it} ") }
