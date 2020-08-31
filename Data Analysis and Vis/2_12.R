library(readr)
library(tidyverse)
nycflights13 <- read_csv("D:/Downloads/nycflights13.csv")

attach(nycflights13)

december <- filter(nycflights13, month==12)
canceled <- filter(december, is.na(december$dep_time))

by_day <- group_by(canceled, canceled$day)
summarise(by_day, canceled = sum(is.na(dep_delay)))
flights_canceled <- summarise(by_day, canceled = sum(is.na(dep_delay)))