import React, { useState } from "react";

export const useCalculator = () => {
  const [currentCalculation, setCurrentCalculation] = useState<string>("0");

  const handlePress = (value: string) => {
    if (currentCalculation === "0" || currentCalculation === "Error") {
      setCurrentCalculation(value);
    } else {
      setCurrentCalculation((prevCalculation) => prevCalculation + value);
    }
  };

  const calculateTotal = () => {
    try {
      const total = evaluateExpression(currentCalculation);
      setCurrentCalculation(total.toString());
    } catch (error) {
      setCurrentCalculation("Error");
    }
  };

  const onPressClear = () => {
    setCurrentCalculation("0");
  };

  const evaluateExpression = (exp: string): number => {
    const tokens = exp
      .split(/([+\-x/])/)
      .filter((token) => token.trim() !== "");

    if (tokens.length === 0) {
      return 0;
    }

    let operands: number[] = [];

    let operators: string[] = [];
    let currentNumber = parseFloat(tokens[0]);

    for (let i = 1; i < tokens.length; i += 2) {
      const operator = tokens[i];
      const nextNumber = parseFloat(tokens[i + 1]);

      if (operator === "x" || operator === "/") {
        if (operator === "x") {
          currentNumber *= nextNumber;
        } else {
          currentNumber /= nextNumber;
        }
      } else {
        operands.push(currentNumber);
        operators.push(operator);
        currentNumber = nextNumber;
      }
    }

    operands.push(currentNumber);

    let result = operands[0];

    for (let i = 0; i < operators.length; i++) {
      if (operators[i] === "+") {
        result += operands[i + 1];
      } else {
        result -= operands[i + 1];
      }
    }

    return result;
  };

  return {
    currentCalculation,
    handlePress,
    calculateTotal,
    onPressClear,
  };
};
