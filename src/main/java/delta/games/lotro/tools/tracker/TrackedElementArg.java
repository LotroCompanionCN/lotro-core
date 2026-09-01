package delta.games.lotro.tools.tracker;

/**
 * Argument of a tracked element.
 * @author DAM
 */
public class TrackedElementArg
{
  private String _name;
  private Object _value;

  /**
   * Constructor.
   * @param name Argument name.
   * @param value Argument value.
   */
  public TrackedElementArg(String name, Object value)
  {
    _name=name;
    _value=value;
  }

  /**
   * Get the name of the managed argument/
   * @return An argument name.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Get the value of the managed argument/
   * @return An argument value.
   */
  public Object getValue()
  {
    return _value;
  }
}
