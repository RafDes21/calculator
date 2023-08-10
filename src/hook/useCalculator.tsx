import React, { useState } from "react";
import { evaluateExpression } from "../utils/mathUtils";

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

  return {
    currentCalculation,
    handlePress,
    calculateTotal,
    onPressClear,
  };
};
