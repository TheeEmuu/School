library(readr)
gpa <- read_csv("D:/Downloads/gpa.csv", col_types = cols(GPA_Semester2 = col_double(), 
                                                         +     StudentID = col_character()))
gpa[] <- lapply(gpa, function(x) ifelse(is.na(x), mean(x, na.rm = TRUE), x))

#1. The measurement of improvement will be skewed more towards the known average 
#gpa of the students rather than be reflective of the actual average

#2. With this specific data, I would treat it as its own statistic, as it seems
#to be people with low GPA in the first semester who don't have data for the 
#second semester. This could mean that they dropped out, which could be an
#important statistic on its own