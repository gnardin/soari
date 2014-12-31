package otservices.translator.valuetransformation.art;

import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.Value.ValueType;

public class TypologyFOREValueTransformation extends FOREValueTransformation {
<<<<<<< HEAD
	
	@Override
	public Value incomingTransformation(Value value) {
		Value v = new Value();
		if(value.getType() == ValueType.STRING) {
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
		if(value.getType() == ValueType.FLOAT) {
			
			float x = ((Float) value.getValue()).floatValue();
			
			this.fromRealtoFORE(new Float(x));
			
			v.setType(ValueType.STRING);
			v.setValue(this.toString());
		}
		
=======

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

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return v;
	}
}
