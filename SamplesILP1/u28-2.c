#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp131; 
  ILP_Object ilptmp132; 
ilptmp131 = ILP_Integer2ILP(1); 
ilptmp132 = ILP_Integer2ILP(2); 

  {
    ILP_Object x1 = ilptmp131;
    ILP_Object y2 = ilptmp132;
{ 
  ILP_Object ilptmp133; 
ilptmp133 = ILP_Integer2ILP(3); 

  {
    ILP_Object y3 = ilptmp133;
{ 
  ILP_Object ilptmp134; 
  ILP_Object ilptmp135; 
ilptmp134 = x1; 
ilptmp135 = y3; 
return ILP_Plus(ilptmp134, ilptmp135);
} 

  }
}

  }
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
