    mov EAX 24
    mov EBX 2
    mov ECX 2
f7: mul EBX EAX
    sub EAX ECX
    jnz EAX f7
    out EBX