#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;
ILP_Object unless;


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp3; 
{ 
  ILP_Object ilptmp4; 
ilptmp4 = ILP_Integer2ILP(2); 
ilptmp3 = ILP_print(ilptmp4);
}
ilptmp3 = unless; 
{ 
  ILP_Object ilptmp5; 
{ 
  ILP_Object ilptmp6; 
  ILP_Object ilptmp7; 
ilptmp6 = ILP_Integer2ILP(2); 
ilptmp7 = ILP_Integer2ILP(4); 
ilptmp5 = ILP_LessThan(ilptmp6, ilptmp7);
} 
  if ( ILP_isEquivalentToTrue(ilptmp5 ) ) {
{ 
  ILP_Object ilptmp8; 
ilptmp8 = ILP_TRUE; 
ilptmp3 = ILP_Not(ilptmp8);
} 

  } else {
{ 
  ILP_Object ilptmp9; 
ilptmp9 = ILP_FALSE; 
ilptmp3 = ILP_Not(ilptmp9);
} 

  }
}
return ilptmp3; 
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
