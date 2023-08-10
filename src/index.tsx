import { View, Text, TouchableHighlight, ScrollView } from "react-native";
import { styles } from "./styles";
import { useCalculator } from "./hook/useCalculator";
import { CalcButton, CalculatorDisplay, OperatorButton } from "./components";

const App = () => {
  const { currentCalculation, onPressClear, handlePress, calculateTotal } =
    useCalculator();

  return (
    <View style={styles.container}>
      <View style={styles.totalContainer}>
        <ScrollView>
          <CalculatorDisplay expression={currentCalculation} />
        </ScrollView>
      </View>
      <View style={styles.btns}>
        <View style={styles.btnsNumbers}>
          <View style={styles.row}>
            <CalcButton label={"AC"} onPress={onPressClear} />
            <CalcButton label={"%"} onPress={handlePress} />
          </View>
          <View style={styles.row}>
            <CalcButton label={"9"} onPress={handlePress} />
            <CalcButton label={"8"} onPress={handlePress} />
            <CalcButton label={"7"} onPress={handlePress} />
          </View>
          <View style={styles.row}>
            <CalcButton label={"6"} onPress={handlePress} />
            <CalcButton label={"5"} onPress={handlePress} />
            <CalcButton label={"4"} onPress={handlePress} />
          </View>
          <View style={styles.row}>
            <CalcButton label={"3"} onPress={handlePress} />
            <CalcButton label={"2"} onPress={handlePress} />
            <CalcButton label={"1"} onPress={handlePress} />
          </View>
          <View style={styles.row}>
            <CalcButton label={"0"} onPress={handlePress} />
            <CalcButton label={"."} onPress={handlePress} />
          </View>
        </View>
        <View style={styles.operatorsRow}>
          <OperatorButton label="+" onPress={() => handlePress("+")} />
          <OperatorButton label="-" onPress={() => handlePress("-")} />
          <OperatorButton label="x" onPress={() => handlePress("x")} />
          <OperatorButton label="/" onPress={() => handlePress("/")} />
          <OperatorButton label="=" onPress={() => calculateTotal()} />
        </View>
      </View>
    </View>
  );
};

export default App;
