import React from "react";
import { View, Text } from "react-native";
import { CalculatorDisplayProps, ColoredTextProps } from "../../types/types";
import { styles } from "./styles";

const ColorText: React.FC<ColoredTextProps> = ({ text, isOperator }) => {
  const textStyle = isOperator ? styles.operatorText : styles.numberText;
  return <Text style={textStyle}>{text}</Text>;
};

const renderColorText = (expression: string) => {
  const parts = expression.split(/([+\-x/])/);
  return parts.map((part, index) => {
    const isOperator =
      part === "+" || part === "-" || part === "x" || part === "/";
    return <ColorText key={index} text={part} isOperator={isOperator} />;
  });
};

const CalculatorDisplay: React.FC<CalculatorDisplayProps> = ({
  expression,
}) => {
  return <Text>{renderColorText(expression)}</Text>;
};

export default CalculatorDisplay;
