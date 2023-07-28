function z = mutation(x)
global NumberOfVariable;
r=randperm(NumberOfVariable);
i=r(1);
j=r(2);

temp=x(j);
x(j)=x(i);
x(i)=temp;

z=x;
end

