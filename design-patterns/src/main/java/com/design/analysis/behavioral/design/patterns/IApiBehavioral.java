package com.design.analysis.behavioral.design.patterns;

import java.util.List;

import com.design.analysis.behavioral.design.patterns.template.HouseTemplate;

/*
 * 
 * @author GuruG
 * 
 * Behavioral Design Patterns
1.	Template Method Pattern
2.	Mediator Pattern
3.	Chain of Responsibility Pattern
4.	Observer Pattern
5.	Strategy Pattern
6.	Command Pattern
7.	State Pattern
8.	Visitor Pattern
9.	Interpreter Pattern
10.	Iterator Pattern
11.	Memento Pattern

 */
public interface IApiBehavioral {

	/** 1. Template Method Pattern **/
	public void templateMethodPattern(HouseTemplate ht);

	/** 2. Mediator Pattern **/
	public void mediatorPattern(List<String> nameList);

	/** 3. Chain of Responsibility Pattern **/
	public void chainOfRespPattern();
	/* 4. Observer Pattern */
	/* 5. Strategy Pattern */
	/* 6. Command Pattern */
	/* 7. State Pattern */
	/* 8. Visitor Pattern */
	/* 9. Interpreter Pattern */
	/* 10. Iterator Pattern */
	/* 11. Memento Pattern */
}
