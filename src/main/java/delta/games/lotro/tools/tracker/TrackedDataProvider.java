package delta.games.lotro.tools.tracker;

import delta.games.lotro.character.CharacterFile;

/**
 * Interface of a object that can provide status data for the generic tracker.
 * @author DAM
 */
public interface TrackedDataProvider
{
  /**
   * Path of the icon to use.
   * @return An icon path.
   */
  String getIcon();
  /**
   * Get the name of the tracked element.
   * @return A displayable name.
   */
  String getName();
  /**
   * Get the type of values.
   * @return A class.
   */
  Class<?> getValueType();
  /**
   * Get the value of a single character.
   * @param input Character to use.
   * @return A value.
   */
  Object getValue(CharacterFile input);
}
