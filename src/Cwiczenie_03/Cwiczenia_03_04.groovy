package TaskSet3

import groovy.json.JsonSlurper

def realNumberRegex = /[+-]?[0-9]+\.[0-9]+|[+-]?[0-9]+/

println("a) Napisać wyrażenie regularne, za pomoca którego mozna odnaleźć w tekście dowolne liczby rzeczywiste.")
def text = "Text 1.50 PLN TextInputTest2.00 PLN 5 PLNInputTest100.30 PLN -200 -12.67"
def numbers = text =~ realNumberRegex

numbers.each { print "${it} " }

println("\nb) zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN, w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)")
def PLNPriceRegex = /[+-]?[0-9]+\.[0-9]+\s+PLN|[+-]?[0-9]+\s+PLN/

def PLNToEURRate = new JsonSlurper().parse(new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur?format=json"))['rates'][0]['mid']
text = text.replaceAll(PLNPriceRegex) { number -> String.format(Locale.US, '%.2f', number.toString().split("\\s").first().toBigDecimal() / (PLNToEURRate as Number)) + " EUR"
}
println(text)
