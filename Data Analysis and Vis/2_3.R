# I would assume that higher horsepower would equal lower city MPG

setwd("D:/Downloads")
df <- read.csv("04carsData.csv")
attach(df)
plot(HP, City.MPG, main="Horsepower vs City MPG", xlab="Horsepower", ylab="City MPG")

# As predicted, the scatterplot seems to show a downward trend in City MPG as horsepower increases