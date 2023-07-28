clc;
clear all;
close all;
global NumberOfVariable;

NumberGeneration=100000000;
NumberOfVariable=200; %number of queens
populationSize=100;
pop.solution=[];
pop.fitness=[];
popAll=repmat(pop,[1 populationSize]);

for i=1:populationSize
    popAll(i).solution=randperm(NumberOfVariable);
    popAll(i).fitness=cost(popAll(i).solution);
end

rateOfMutate=0.35;
numberOfMutate=round(rateOfMutate*populationSize);
popM=repmat(pop,[1 numberOfMutate]);
bestSoltionInGeneration=zeros(1,NumberGeneration);

for k=1:NumberGeneration   
    for i=1:numberOfMutate
        r=randi(populationSize);
        x=popAll(r).solution;
        popM(i).solution=mutation(x);
        popM(i).fitness=cost(popM(i).solution);
    end
    
    popMiddle=[popAll popM];
    [fitnessValue,indexOfMember]=sort([popMiddle.fitness]);
    bestSolution=fitnessValue(1)
    bestSoltionInGeneration(k)=bestSolution;
    
    figure(1);
    plot(bestSoltionInGeneration(1:k),'-r');
    
     
    if(bestSolution==0)
        popMiddle(indexOfMember(1)).solution
        break;
    end
    
    popAll=popMiddle(indexOfMember(1:populationSize));
    
   
end

popMiddle(indexOfMember(1)).solution
popMiddle(indexOfMember(1)).fitness







