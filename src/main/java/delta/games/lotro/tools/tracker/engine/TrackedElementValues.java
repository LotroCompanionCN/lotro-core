package delta.games.lotro.tools.tracker.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Gathers the values of a tracked element for several characters.
 * @author DAM
 */
public class TrackedElementValues
{
  private String _icon;
  private String _name;
  private List<Object> _values;

  /**
   * Constructor.
   * @param icon Icon path to use.
   * @param name Name to use.
   */
  public TrackedElementValues(String icon, String name)
  {
    _icon=icon;
    _name=name;
    _values=new ArrayList<Object>();
  }

  /**
   * Get the path of the icon to use.
   * @return an icon path.
   */
  public String getIcon()
  {
    return _icon;
  }

  /**
   * Get the name of the tracked element.
   * @return A name.
   */
  public String getName()
  {
    return _name;
  }

  /**
   * Get the managed values.
   * @return the managed values.
   */
  public List<Object> getValues()
  {
    return _values;
  }

  /**
   * Add a value.
   * @param value Value to add.
   */
  public void addValue(Object value)
  {
    _values.add(value);
  }
}
