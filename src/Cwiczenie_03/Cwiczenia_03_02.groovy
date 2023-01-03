package TaskSet3

def pmap = [Groovy: ['Asia', 'Jan'],
            Grails: ['Asia', 'Jan', 'Stefan', 'Mirek'],
            Java  : ['Asia', 'Stefan', 'Mirek'],
            JEE   : ['Slawek', 'Stefan', 'Janusz']
]

println("a) ile osób pracuje w każdym z projektów")
pmap.each { println("${it.key} - ${it.value.size()}") }

println("b) projekty, które mają więcej niż dwóch programistów")
pmap.findAll { it.value.size() > 2 }.each { print("${it.key} ") }

println("\nc)  w jakich projektach biorą udzial poszczególni programisci")
pmap.values().flatten().unique().each { name -> println("${name} - ${pmap.findAll { it.value.contains(name) }.collect { it.key }}") }
