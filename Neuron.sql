CREATE TABLE neuron (neuronID INT PRIMARY KEY NOT NULL, value REAL, bias INT, neuronType CHAR (1));

CREATE TABLE neuronInputs (inputID INT PRIMARY KEY NOT NULL, inputType TEXT, inputSpecific CHAR(1), inputWeight REAL);

CREATE TABLE neuronOutputs (outputID INT PRIMARY KEY NOT NULL, outputType TEXT, outputSpecific CHAR(1), ouputWeight REAL);
 
INSERT INTO neuronInputs VALUES(1, 'unipolar', 'u', 0.1);
 
INSERT INTO neuronInputs VALUES(2, 'unipolar', 'u', 0.1);

INSERT INTO neuronOutputs VALUES(1, 'unipolar', 'u', 0.1);
 
INSERT INTO neuronOutputs VALUES(2, 'unipolar', 'u', 0.1);

INSERT INTO neuron VALUES (1, 1, 'u', 0.2);

CREATE TABLE neuron_input (id INT NOT NULL, neuronID, inputID);

CREATE TABLE neuron_output(id INT NOT NULL, neuronID, outputID);

INSERT INTO neuron_input VALUES(1, 1, 1);

INSERT INTO neuron_input VALUES(2, 1, 2);

INSERT INTO neuron_output VALUES(1, 1, 1);

INSERT INTO neuron_output VALUES(2, 1, 2);

select * from neuronInputs;

select * from neuronOutputs;

select * from neuron_input;

select * from neuron_output;
