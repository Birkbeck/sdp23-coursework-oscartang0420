    mov EAX 8
f5: mov EBX 4
    div EAX EBX
    out EAX
    mov ECX 32
f2: mul ECX EAX
    out EBX