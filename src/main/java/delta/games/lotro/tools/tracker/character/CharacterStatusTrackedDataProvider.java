package delta.games.lotro.tools.tracker.character;

import delta.games.lotro.character.CharacterFile;
import delta.games.lotro.common.money.Money;
import delta.games.lotro.tools.tracker.TrackedDataProvider;
import delta.games.lotro.tools.tracker.TrackedElementTypes;

/**
 * Provider for character status data.
 * @author DAM
 */
public class CharacterStatusTrackedDataProvider implements TrackedDataProvider
{
  private String _type;

  /**
   * Constructor.
   * @param type Type to use.
   */
  public CharacterStatusTrackedDataProvider(String type)
  {
    _type=type;
  }

  @Override
  public String getIcon()
  {
    return null;
  }

  @Override
  public String getName()
  {
    if (TrackedElementTypes.CHARACTER_LEVEL.equals(_type)) return "Level";
    if (TrackedElementTypes.CHARACTER_MONEY.equals(_type)) return "Money";
    return null;
  }

  @Override
  public Class<?> getValueType()
  {
    if (TrackedElementTypes.CHARACTER_LEVEL.equals(_type)) return Integer.class;
    if (TrackedElementTypes.CHARACTER_MONEY.equals(_type)) return Money.class;
    return null;
  }

  @Override
  public Object getValue(CharacterFile input)
  {
    if (TrackedElementTypes.CHARACTER_LEVEL.equals(_type))
    {
      return Integer.valueOf(input.getSummary().getLevel());
    }
    else if (TrackedElementTypes.CHARACTER_MONEY.equals(_type))
    {
      return input.getDetails().getMoney();
    }
    return null;
  }
}
