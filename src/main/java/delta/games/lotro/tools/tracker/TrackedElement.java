package delta.games.lotro.tools.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Description of a tracked element.
 * @author DAM
 */
public class TrackedElement
{
  private String _type;
  private List<TrackedElementArg> _args;

  /**
   * Constructor.
   * @param type Type of the tracked element.
   */
  public TrackedElement(String type)
  {
    _type=type;
    _args=new ArrayList<TrackedElementArg>();
  }

  /**
   * Get the type of this tracked element.
   * @return A type (see class TrackedElementTypes).
   */
  public String getType()
  {
    return _type;
  }

  /**
   * Add an argument.
   * @param arg Argument to add.
   */
  public void addArg(TrackedElementArg arg)
  {
    _args.add(arg);
  }

  /**
   * Get the arguments that define the tracked element.
   * @return A list of tracked element arguments.
   */
  public List<TrackedElementArg> getArgs()
  {
    return _args;
  }

  /**
   * Get the value of an argument.
   * @param argName Argument name.
   * @return A value or <code>null</code> if not found.
   */
  public Object getArgValue(String argName)
  {
    for(TrackedElementArg arg : _args)
    {
      if (argName.equals(arg.getName()))
      {
        return arg.getValue();
      }
    }
    return null;
  }
}
