package turtle.model;

public final class CommandUndo {
	
	public static void use(Turtle t) {
		if (!t.getCommands().isEmpty()) {
			String cmd = t.getCommands().peek(), command="", parameters="";
			boolean found = false;
			for (int i=0; i<cmd.length()-1; i++) {
				if (found) {
					parameters = parameters + cmd.charAt(i);
				}else if (cmd.charAt(i)=='(') {
					found = true;
				}else {
					command = command + cmd.charAt(i);
				}
			}
			switch (command) {
				case "go":
					CommandGo.undo(t, parameters);
					break;
				case "turn":
					CommandTurn.undo(t, parameters);
					break;
				case "color":
					CommandColor.undo(t);
					break;
				case "draw":
					CommandDraw.undo(t);
					break;
				default:
					break;
			}
			t.getCommands().pop();	// remove the head of the stack
		}
	}
	
}
