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
