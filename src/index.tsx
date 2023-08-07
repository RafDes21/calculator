import React, { useState } from "react";
import { View, Text, TouchableHighlight } from "react-native";
import { styles } from "./styles";

const App = () => {
  const [currentCalculation, setCurrentCalculation] = useState<string>("0");

  const handlePress = (value: string) => {
    if (currentCalculation === "0" || currentCalculation === "Error") {
      setCurrentCalculation(value);
    } else {
      setCurrentCalculation(prevCalculation => prevCalculation + value);
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
    const tokens = exp.split(/([+\-x/])/).filter(token => token.trim() !== '');
  
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
  
  return (
    <View style={styles.container}>
      <View style={styles.totalContainer}>
        <Text style={styles.totalText}>{currentCalculation}</Text>
      </View>
      <View style={styles.btns}>
        <View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => onPressClear()}
              style={styles.btn}
            >
              <Text style={styles.btnText}>AC</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("%")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>%</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("9")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>9</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("8")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>8</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("7")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>7</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("6")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>6</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("5")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>5</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("4")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>4</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("3")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>3</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("2")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>2</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("1")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>1</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress("0")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>0</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={() => handlePress(".")}
              style={styles.btn}
            >
              <Text style={styles.btnText}>.</Text>
            </TouchableHighlight>
          </View>
        </View>
        <View style={styles.operatorsRow}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={() => handlePress("+")}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>+</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={() => handlePress("-")}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>-</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={() => handlePress("x")}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>x</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={() => handlePress("/")}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>/</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={() => calculateTotal()}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>=</Text>
          </TouchableHighlight>
        </View>
      </View>
    </View>
  );
};

export default App;
