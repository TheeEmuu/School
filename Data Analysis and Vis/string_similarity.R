string_similarity <- function(csv1, csv2){
  a <- read.csv(csv1)
  b <- read.csv(csv2)
  
  a_column <- readline(prompt = "Column of intrest for the first csv: ")
  b_column <- readline(prompt = "Column of intrest for the second csv: ")
  
  a_data <- a[, a_column]
  b_data <- b[, b_column]
  
  t <- readline(prompt = "How similar do the objects need to be? : ")
  type <- readline(prompt = "Edit similarity or Jacard similarity? : ")
  if(tolower(type) == "jacard similarity"){
    q <- readline("What is the q value? : ")
    jacard(a_data, b_data, q, t)
  }
  else{
    edit_dist(a_data, b_data, t)
  }
}

jaccard <- function(a_data, b_data, q, t){
  a_q_grams <- vector(mode = "list", length = length(a_data))
  b_q_grams <- vector(mode = "list", length = length(b_data))
  
  
  for(i in 1:length(a_data)){
    a_q_grams[i] <- q_grams(a_data[i], q)
  }
  for(i in 1:length(b_data)){
    b_q_grams[i] <- q_grams(b_data[i], q)
  }
  
  for(i in a_q_grams){
    for(k in b_b_grams){
      same <- intersect(i, k)
      total <- union(i, k)
      sim <- same / total
      
      if(sim > t){
        
      }
    }
  }
}

q_grams(word, q){
  grams <- vector(mode = "list", length = nchar(word) - (q - 1))
  for(i in 1:length(grams)){
    grams[i] <- substr(word, i, i - 1 + q)
  }
  
  return(grams)
}

edit_dist <- function(a_data, b_data, t){
  
}

