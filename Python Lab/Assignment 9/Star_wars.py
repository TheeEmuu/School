import swapi
import requests
import json


def get_external(a):
    a = a.split("/")
    return a[5]


search = "Boba fet"

url = 'https://swapi.co/api/people/'
r = requests.get(url, params={'search': search})
data = json.loads(r.text)


attributes = ("name", "birth_year", "eye_color", "gender", "hair_color", "height", "mass", "skin_color")
for x in attributes:
    print(x + ": " + data["results"][0][x])

#homeworld
print("Homeworld: " + (swapi.get_planet(get_external(data["results"][0]["homeworld"]))).name)

#films
print("Films:")
a = len(data["results"][0]["films"])
for j in range(0, a):
    print("    " + swapi.get_film(get_external(data["results"][0]["films"][j])).title)


attributes = ("species", "starships", "vehicles")
for x in attributes:
    print(x + ":")
    a = len(data["results"][0][x])
    for j in range(0, a):
        # MOVE get_film to url search
        print("    " + swapi.get_film(get_external(data["results"][0][x][j])).name)


