package delta.games.lotro.tools.tracker;

import delta.games.lotro.lore.deeds.DeedsManager;
import delta.games.lotro.lore.quests.Achievable;

/**
 * Builds lists of tracked elements.
 * @author DAM
 */
public class TrackedListsBuilder
{
  private TrackedElement buildCompletedAchievableTrackedElement(Achievable achievable)
  {
    TrackedElement ret=new TrackedElement(TrackedElementTypes.DEED_COMPLETED);
    ret.addArg(new TrackedElementArg(ArgNames.ID,Integer.valueOf(achievable.getIdentifier())));
    return ret;
  }

  /**
   * Build tracked elements for the completion state of 'survivor' deeds.
   * @return A collection of tracked elements.
   */
  public TrackedElements buildSurvivorList()
  {
    TrackedElements ret=new TrackedElements();
    DeedsManager mgr=DeedsManager.getInstance();
    ret.addElement(buildCompletedAchievableTrackedElement(mgr.getDeed(1879071646))); // The Wary
    ret.addElement(buildCompletedAchievableTrackedElement(mgr.getDeed(1879071647))); // The Undefeated
    ret.addElement(buildCompletedAchievableTrackedElement(mgr.getDeed(1879071648))); // The Indomitable
    ret.addElement(buildCompletedAchievableTrackedElement(mgr.getDeed(1879071649))); // The Unscathed
    ret.addElement(buildCompletedAchievableTrackedElement(mgr.getDeed(1879071650))); // The Undying
    return ret;
  }

  /**
   * Build tracked elements for the basic attributes of characters.
   * @return A collection of tracked elements.
   */
  public TrackedElements buildCharacterBasics()
  {
    TrackedElements ret=new TrackedElements();
    ret.addElement(new TrackedElement(TrackedElementTypes.CHARACTER_LEVEL));
    ret.addElement(new TrackedElement(TrackedElementTypes.CHARACTER_MONEY));
    return ret;
  }
}
