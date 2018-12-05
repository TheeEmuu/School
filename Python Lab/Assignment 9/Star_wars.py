import swapi
import requests
import json


def get_external(a):
    a = a.split("/")
    return a[5]

def get(type, value):
    if(type == "film"):
        return swapi.get_film(value).title
    if(type == "species"):
        return swapi.get_species(value).name
    if(type == "starships"):
        return swapi.get_starship(value).name
    if(type == "vehicles"):
        return swapi.get_vehicle(value).name


search = "luke skywalker"

url = 'https://swapi.co/api/people/'
r = requests.get(url, params={'search': search})
data = json.loads(r.text)
print(data)
data = data["results"][0]


attributes = ("name", "birth_year", "eye_color", "gender", "hair_color", "height", "mass", "skin_color")
for x in attributes:
    print(x + ": " + data[x])

#homeworld
print("Homeworld: " + (swapi.get_planet(get_external(data["homeworld"]))).name)

# #films
# print("Films:")
# a = len(data["films"])
# for j in range(0, a):
#     print("    " + swapi.get_film(get_external(data["films"][j])).title)


attributes = ("films", "species", "starships", "vehicles")
for x in attributes:
    print(x + ":")
    for j in range(0, len(data[x])):
        # MOVE get_film to url search
        #print("    " + swapi.get_film(get_external(data[x][j])).name)
        print("    " + get(x, get_external(data[x][j])))
