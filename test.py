#!/usr/bin/python

import requests

def read(filename):
    f = open(filename,'r')
    file = f.read()
    f.close()
    return file


res = requests.post('http://localhost:8080/runScript', data = {
    'script': read('test.groovy')
})

print res.text