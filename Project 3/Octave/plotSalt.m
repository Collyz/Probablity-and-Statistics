clear all
file = 'SalterData.csv';
A = csvread(file);
x = A(:, 1);
y = A(:, 2);
plot(x, y);
grid on;
title('Salted Data');
set(gca,'fontsize',16);
xlabel('x Values');
ylabel('y Values');

