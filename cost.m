function z = cost(x)
global NumberOfVariable;
count=0;
for i=1:NumberOfVariable-1
    for j=i+1:NumberOfVariable
        if(abs(i-j)==abs(x(i)-x(j)))
            count=count+1;
        end
    end
end
z=count;
end

