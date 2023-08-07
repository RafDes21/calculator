import React, { useState } from "react";
import { View, Text, TouchableHighlight } from "react-native";
import { styles } from "./styles";

const App = () => {
  const [data, setData] = useState<string[]>(["0"]);
  // const [resultShown, setResultShown] = useState<boolean>(false);

  const handlePress = (value: string) => {

    if (data[0] === "0") {
      setData([value])
    } else {
      setData([...data, value]);
    }
  };

  const calculateTotal = () => {
    try {
      let result = 0;
      let currentOperator = "+";

      data.forEach((item) => {
        if (["+", "-", "x", "/"].includes(item)) {
          currentOperator = item;
        } else {
          switch (currentOperator) {
            case "+":
              result += parseFloat(item);
              break;
            case "-":
              result -= parseFloat(item);
              break;
            case "x":
              result *= parseFloat(item);
              break;
            case "/":
              result /= parseFloat(item);
              break;
            default:
              break;
          }
        }
      });

      setData([result.toString()]);
      // setResultShown(true);
    } catch (error) {
      setData(["Error"]);
    }
  };

  const onPressClear = () => {
    setData(["0"]);
  };

  return (
    <View style={styles.container}>
      <View style={styles.totalContainer}>
        <Text style={styles.totalText}>{data}</Text>
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
