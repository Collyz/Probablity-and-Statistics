clear all
file = 'SalterData.csv';
A = csvread(file);
x = A(:, 1);
y = A(:, 2);
yAvg = movmean(y, 4);
plot(x, yAvg);
grid on;
title('Smoothed Data');
set(gca,'fontsize',16);
xlabel('x Values');
ylabel('y Values');
