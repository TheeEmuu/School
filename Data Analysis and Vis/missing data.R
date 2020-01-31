library(readr)

# INPUT:  the table to be modified (data) and the value that represents a missing value (representation)
# RETURN: a table with the specified representation replaced with NA
to_na <-function(data, representation){
  data[data==representation] <- NA
  return(data)
}

# INPUT:  two strings (a and b) and their lengths (len_a and len_b)
# RETURN: the edit distance between the two strings
edit_distance <- function(a, len_a, b, len_b){
  if(len_a == 0) return(len_b)
  if(len_b == 0) return(len_a)
  
  if(substr(a, len_a, len_a) == substr(b, len_b, len_b)){
    cost = 0
  }
  else{
    cost = 1
  }
  
  x <- c(
    edit_distance(a, len_a - 1, b, len_b) + 1, #delete from a
    edit_distance(a, len_a, b, len_b - 1) + 1, #delete from b
    edit_distance(a, len_a - 1, b, len_b - 1) + cost  #delete from both
  )
  
  return(min(x))
}

# INPUT:  the table to be cleaned (data)
# RETURN: a table with missing values ignored
ignore_missing <- function(data){
  data <- data[complete.cases(data), ]
  return data
}

# INPUT:  the table to be cleaned (data)
# RETURN: a table with missing values ignored
mean <- function(data){
  for(i in 1:ncol(data)){
    data[is.na(data[,i]), i] <- mean(data[,i], na.rm=TRUE)
  }
  return(data)
}


# INPUT:  the table to be cleaned (data)
# RETURN: a table with missing values ignored
linear_regression <- function(data){
  linear <- lm(data$)
}