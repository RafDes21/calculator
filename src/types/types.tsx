import { ReactNode } from "react";
import { ViewStyle } from "react-native";

export interface ContentButtonProps {
  children: ReactNode;
  style?: ViewStyle;
}

export interface BtnsProps {
  label: string;
  onPress: (value: string) => void;
}

export interface CalculatorDisplayProps {
  expression: string;
}

export interface ColoredTextProps {
  text: string;
  isOperator: boolean;
}
