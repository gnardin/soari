package otservices.translator.valuetransformation.art;

import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.Value.ValueType;

public class TypologyFOREValueTransformation extends FOREValueTransformation {

	@Override
	public Value incomingTransformation(Value value) {
		Value v = new Value();
		if (value.getType() == ValueType.STRING) {
			this.setValues((String) value.getValue());

			v.setType(ValueType.FLOAT);

			float x = this.fromFOREtoReal().floatValue();

			v.setValue(new Float(x));
		}

		return v;
	}

	@Override
	public Value outgoingTransformation(Value value) {
		Value v = new Value();
		if (value.getType() == ValueType.FLOAT) {

			float x = ((Float) value.getValue()).floatValue();

			this.fromRealtoFORE(new Float(x));

			v.setType(ValueType.STRING);
			v.setValue(this.toString());
		}

		return v;
	}
}
