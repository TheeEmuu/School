import swapi
import requests
import json


def get_external(a):
    a = a.split("/")
    return a[5]


def get(attribute, value):
    if attribute == "films":
        return swapi.get_film(value).title
    if attribute == "species":
        return swapi.get_species(value).name
    if attribute == "starships":
        return swapi.get_starship(value).name
    if attribute == "vehicles":
        return swapi.get_vehicle(value).name


def read_api(search):
    url = 'https://swapi.co/api/people/'
    r = requests.get(url, params={'search': search})
    data = json.loads(r.text)
    return data["results"][0]


def main():
    search = input(str("Please input a Star Wars character: "))

    data = read_api(search)

    # read in single value attributes
    attributes = ("name", "birth_year", "eye_color", "gender", "hair_color", "height", "mass", "skin_color")
    for x in attributes:
        print(x + ": " + data[x])

    # homeworld
    print("Homeworld: " + (swapi.get_planet(get_external(data["homeworld"]))).name)

    # read in multi value attributes
    attributes = ("films", "species", "starships", "vehicles")
    for x in attributes:
        print(x + ":")
        for j in range(0, len(data[x])):
            print("    " + str(get(x, get_external(data[x][j]))))


main()
