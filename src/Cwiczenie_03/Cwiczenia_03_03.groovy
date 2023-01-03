package TaskSet3

import java.text.ParseException
import java.text.SimpleDateFormat

def dateFormatter = new SimpleDateFormat("yyyy-MM-dd")
dateFormatter.setLenient(false)

def text = "fasffasf2021-10-20asdads2020-01-05-asda-050asd-2022-30-20"
def matches = text =~ /[0-9]{4}-[0-9]{2}-[0-9]{2}/

def validated = matches.findAll {
    def valid = true
    try {
        dateFormatter.parse(it as String)
    } catch (ParseException e) {
        valid = false
    }
    valid
}

validated.forEach { println(it) }
