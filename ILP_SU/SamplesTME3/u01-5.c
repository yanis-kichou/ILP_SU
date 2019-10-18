#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object makeVector;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp14; 
  ILP_Object ilptmp15; 
ilptmp14 = ILP_Integer2ILP(5); 
ilptmp15 = ILP_Integer2ILP(5); 
return ILP_makeVector(ilptmp14, ilptmp15);
}

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
