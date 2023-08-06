import React from "react";
import { View, Text, TouchableHighlight } from "react-native";
import { styles } from "./styles";

const App = () => {
  const onPress = () => {};

  return (
    <View style={styles.container}>
      <View style={styles.totalContainer}>
        <Text style={styles.totalText}>Total</Text>
      </View>
      <View style={styles.btns}>
        <View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>AC</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>%</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>9</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>8</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>7</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>6</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>5</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>4</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>3</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>2</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>1</Text>
            </TouchableHighlight>
          </View>
          <View style={styles.row}>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>0</Text>
            </TouchableHighlight>
            <TouchableHighlight
              underlayColor="#DDDDDD"
              onPress={onPress}
              style={styles.btn}
            >
              <Text style={styles.btnText}>.</Text>
            </TouchableHighlight>
          </View>
        </View>
        <View style={styles.operatorsRow}>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>+</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>-</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>x</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
            style={styles.operatorBtn}
          >
            <Text style={styles.operatorBtnText}>/</Text>
          </TouchableHighlight>
          <TouchableHighlight
            underlayColor="#DDDDDD"
            onPress={onPress}
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
